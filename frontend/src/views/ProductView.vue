<template>
  <h1>Product page</h1>

  <div class="form-container">
    <div>
      <form @submit.prevent="createNewProduct" class="form">
        <h8 style="margin-bottom: 10px">Create baby here:</h8>
        <label for="name">Name</label>
        <input v-model="newProduct.name" id="name" required />
        <label for="age">Age</label>
        <input v-model="newProduct.age" type="number" id="age" required />
        <label for="ethnicity">Ethnicity</label>
        <input v-model="newProduct.ethnicity" id="ethnicity" required />
        <label for="weight">Weight</label>
        <input
          v-model="newProduct.weight"
          type="number"
          id="weight"
          step="0.01"
          required
        />
        <label for="price">Price</label>
        <input
          v-model="newProduct.price"
          type="number"
          id="price"
          step="0.01"
          required
        />
        <button type="submit" style="margin-top: 10px">Insert Baby</button>
      </form>
    </div>

    <div v-if="selectedProduct">
      <form @submit.prevent="updateExistingProduct" class="form">
        <h8 style="margin-bottom: 10px">Update {{ selectedProduct.name }}:</h8>

        <label for="name">Name</label>
        <input v-model="selectedProduct.name" id="name" required />
        <label for="age">Age</label>
        <input v-model="selectedProduct.age" type="number" id="age" required />
        <label for="ethnicity">Ethnicity</label>
        <input v-model="selectedProduct.ethnicity" id="ethnicity" required />
        <label for="weight">Weight</label>
        <input
          v-model="selectedProduct.weight"
          type="number"
          id="weight"
          step="0.01"
          required
        />
        <label for="price">Price</label>
        <input
          v-model="selectedProduct.price"
          type="number"
          id="price"
          step="0.01"
          required
        />
        <button type="submit" style="margin-top: 10px">Update Baby</button>
      </form>
    </div>
  </div>

  <div class="container">
    <div class="card" v-for="product in products" :key="product.id">
      <div class="card-header">
        Name: {{ product.name }} | Age: {{ product.age }}
      </div>
      <div class="card-body">
        <h6 class="ethnicity text-muted">
          Ethnicity: {{ product.ethnicity }}
          <br />
          Weight: {{ product.weight }}kg
          <br />
          Price: {{ product.price }}kr
        </h6>
        <button @click="updateProductDetails(product)">Update</button>
        <button @click="deleteProductDetails(product)">Delete</button>
      </div>
    </div>
  </div>
</template>

<style>
.card {
  width: 18rem;
  border: 2px solid black;
}

.card-body {
  padding: 5px;
}

.card-header {
  border-bottom: 2px solid black;
  padding: 5px;
}
.container {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(18rem, 1fr));
  gap: 14px;
  padding: 16px;
}

.form-container {
  float: left;
}

.form {
  display: flex;
  flex-direction: column;
  max-width: 400px;
  margin: 10px auto;
}
</style>

<script>
import {
  getAllProducts,
  createProduct,
  updateProduct,
  deleteProduct,
} from "@/services/ProductService";

export default {
  data() {
    return {
      products: [],
      newProduct: {
        name: "",
        age: 0,
        ethnicity: "",
        weight: 0,
        price: 0,
      },
      selectedProduct: null,
    };
  },
  async mounted() {
    this.fetchProducts();
  },
  methods: {
    async fetchProducts() {
      try {
        const response = await getAllProducts();
        this.products = response.data;
      } catch (error) {
        console.error("Error fetching products:", error);
      }
    },

    async createNewProduct() {
      try {
        const response = await createProduct(this.newProduct);
        this.products.push(response.data);
        this.newProduct.name = "";
        this.newProduct.age = 0;
        this.newProduct.ethnicity = "";
        this.newProduct.weight = 0;
        this.newProduct.price = 0;
      } catch (error) {
        console.error("Error creating product:", error);
      }
    },

    async updateExistingProduct() {
      try {
        const response = await updateProduct(this.selectedProduct);
        const index = this.products.findIndex(
          (p) => p.id === this.selectedProduct.id
        );
        this.products.splice(index, 1, response.data); // Replace updated product
        await this.fetchProducts();
        this.selectedProduct = null;
      } catch (error) {
        console.error("Error updating product:", error);
      }
    },

    async deleteProductDetails(product) {
      try {
        const response = await deleteProduct(product);
        this.products = this.products.filter((p) => p.id !== product.id);
      } catch (error) {
        console.error("Error deleting product:", error);
      }
    },

    updateProductDetails(product) {
      this.selectedProduct = { ...product };
    },
  },
};
</script>
