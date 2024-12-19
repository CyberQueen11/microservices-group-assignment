<script>
import ProductForm from "@/components/ProductForm.vue";
import {
  getAllProducts,
  createProduct,
  updateProduct,
  deleteProduct,
} from "@/services/ProductService";

export default {
  components: {
    ProductForm,
  },
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
        this.products.splice(index, 1, response.data);
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

<template>
  <h1>Product page</h1>

  <div class="form-container">
    <div>
      <ProductForm
        :productData="newProduct"
        form-title="Create baby here:"
        submit-button-text="Insert Baby"
        @submit="createNewProduct"
      />
    </div>

    <div v-if="selectedProduct">
      <ProductForm
        :productData="selectedProduct"
        submit-button-text="Update baby"
        @submit="updateExistingProduct"
        isUpdate="true"
      />
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
