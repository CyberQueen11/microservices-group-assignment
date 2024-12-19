<script setup>
import { RouterLink, RouterView, useRoute } from "vue-router";
import { computed } from "vue";

const route = useRoute();

const showLinks = computed(() => {
  return ["/product", "/owner", "/purchase"].includes(route.path);
});
</script>

<template>
  <header>
    <div class="wrapper">
      <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink v-if="showLinks" to="/product">Products</RouterLink>
        <RouterLink v-if="showLinks" to="/owner">Owner</RouterLink>
        <RouterLink v-if="showLinks" to="/purchase">Purchase</RouterLink>
      </nav>
    </div>
  </header>

  <RouterView />
</template>
