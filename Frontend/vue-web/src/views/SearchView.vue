<template>
    <div class="search">
      <button type="submit" @click="search"> 查詢 </button>
        <table :data="tableData" style="margin-left:auto; margin-right:auto;" >
            <thead>
              <tr>
                  <th>商品編號</th>
                  <th>商品名稱</th>
                  <th>售價</th>
                  <th>庫存</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="item in tableData" :key="item.productId">
                  <td>{{ item.productId }}</td>
                  <td>{{ item.productName }}</td>
                  <td>{{ item.price }}</td>
                  <td>{{ item.quantity }}</td>
              </tr>
            </tbody>
        </table>
    </div>
</template>

<script lang="ts">
import axios from 'axios';
import { defineComponent } from 'vue';
axios.defaults.baseURL = 'http://localhost:8080'; 

var axiosConfig = {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                        'Accept': '*',
                      }
                };

export default defineComponent({
  name: 'SearchView',
  data(){
    return{
      tableData: []
    }

  },
  created() {
    this.search();
  },
  methods:{
    search(){
      axios.get('http://localhost:8080/search', axiosConfig)
      .then(res =>{
         this.tableData = res.data;
        })
        .catch(error => {
        console.error('Error:', error);
        });
    }
  }
});
</script>
<style>
table {
  border: 2px solid #42b983;
  border-radius: 3px;
  background-color: #fff;
}

th {
  background-color: #42b983;
  color: rgba(255,255,255,0.66);
}

td {
  background-color: #f9f9f9;
}

th, td {
  min-width: 120px;
  padding: 10px 20px;
}

</style>