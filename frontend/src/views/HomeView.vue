<script setup>
import {RouterLink} from "vue-router";
</script>

<template>
  <main>
    <ul>
      <li>
        <RouterLink to="/product">Product</RouterLink>
      </li>
      <li>
        <RouterLink to="/owner">Owner</RouterLink>
      </li>
      <li>
        <RouterLink to="/purchase">Purchase</RouterLink>
      </li>
    </ul>
  </main>
</template>
