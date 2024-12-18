<template>
  <form @submit.prevent="handleSubmit" class="form">
    <h8 style="margin-bottom: 10px">{{
      isUpdate ? "Update " + productData.name : formTitle
    }}</h8>
    <label for="name">Name</label>
    <input v-model="productData.name" id="name" required />
    <label for="age">Age</label>
    <input v-model="productData.age" type="number" id="age" required />
    <label for="ethnicity">Ethnicity</label>
    <input v-model="productData.ethnicity" id="ethnicity" required />
    <label for="weight">Weight</label>
    <input
      v-model="productData.weight"
      type="number"
      id="weight"
      step="0.01"
      required
    />
    <label for="price">Price</label>
    <input
      v-model="productData.price"
      type="number"
      id="price"
      step="0.01"
      required
    />
    <button type="submit" style="margin-top: 10px">
      {{ submitButtonText }}
    </button>
  </form>
</template>

<script>
export default {
  props: {
    productData: {
      type: Object,
      required: true,
    },
    formTitle: {
      type: String,
      default: "Product Form",
    },
    submitButtonText: {
      type: String,
      default: "Submit",
    },
    isUpdate: {
      type: Boolean,
      required: false,
    },
  },
  data() {
    return {
      product: { ...this.productData },
    };
  },
  methods: {
    handleSubmit() {
      this.$emit("submit", this.product);
    },
  },
};
</script>

<style scoped>
.form {
  display: flex;
  flex-direction: column;
  max-width: 400px;
  margin: 10px auto;
}
</style>
