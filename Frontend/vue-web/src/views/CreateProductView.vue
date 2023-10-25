<template>
    <div class="center-form">
        <form label-width="80px" @submit.prevent="save">
            <div><label>商品編號：</label> <input type="text" v-model="formData.productId"></div>   
            <div><label>商品名稱：</label> <input type="text" v-model="formData.productName"></div>    
            <div><label>售價：</label> <input onkeyup="value = value.replace(/^(0+)|[^\d]+/g,'')" v-model="formData.price">  </div>        
            <div><label>庫存：</label> <input onkeyup="value = value.replace(/^(0+)|[^\d]+/g,'')" v-model="formData.quantity"> </div>   
            <div><button type="submit"> 送出 </button></div>   
            <div v-if="show_ok">{{ messageText }}</div>
        </form>
    </div>
</template>

<script lang="ts">
import axios from 'axios';
import { defineComponent } from 'vue';

var axiosConfig = {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                        'Accept': '*',
                      }
                };

export default defineComponent({
  name: 'CreateProductView',
  components: {
    // HelloWorld,
  },
  data(){
    return{
        messageText : "",
        show_ok : false,
        formData: {
          productId: "",
          productName: "",
          price: 0,
          quantity: 0
        }
    };
  },
  methods:{
    save(){
        axios.post('http://localhost:8080/createProduct', this.formData, axiosConfig)
        .then(res =>{
          if (res.status ==200){
            this.show_ok = true;
            this.messageText = "新增成功!";
            this.formData.productId= "";
            this.formData.productName= "";
            this.formData.price= 0;
            this.formData.quantity= 0;
          }
          else{
            this.show_ok = true;
            this.messageText = "新增失敗!";
            this.formData.productId= "";
            this.formData.productName= "";
            this.formData.price= 0;
            this.formData.quantity= 0;
          }
        })
        .catch(error => {
        console.error('Error:', error);
        });
    }
  }
});
</script>

<style>
.center-form {
  margin: 10px;
  display: flex;
  flex-direction: column;
  text-align: center; 
  display: grid;
}
</style>