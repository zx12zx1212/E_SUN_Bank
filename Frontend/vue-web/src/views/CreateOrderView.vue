<template>
    <div class="search">
      <!-- <button type="submit" @click="createOrder"> 新增訂單 </button> -->
      <button type="submit" @click="save">建立訂單 </button>
      <div v-if="show_ok">{{ messageText }}</div>
      <div><label>會員編號：</label> <input type="text" v-model="formOrderData.orderID.memberID"></div>
        <table :data="tableData" style="margin-left:auto; margin-right:auto;" >
            <thead>
              <tr>
                  <th>商品名稱</th>
                  <th>售價</th>
                  <th>庫存</th>
                  <th>訂購數量</th>
                  <th>小計</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="item in tableData" :key="item.productId">
                  <td>{{ item.productName }}</td>
                  <td>{{ item.price }}</td>
                  <td>{{ item.quantity }}</td>
                  <td>
                    <input onkeyup="value = value.replace(/^(0+)|[^\d]+/g,'')" v-model="item.number">
                  </td>
                  <td>
                    <p>{{ item.price * item.number }} </p>
                  </td>
              </tr>
              <div> 目前總計：{{ total() }}</div>

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
      show_ok:false,
      messageText:"",
      total_price : 0,
      minValue: 0,
      maxValue: 100,
      tableData: [
        {
          productId:"",
          productName:"",
          price: 0,
          quantity:"",
          number: 0,
        }
      ],
      formOrderData: {
        orderID: {
            orderDetail: null,
            payStatus: false,
            orderID: "",
            memberID: "",
            price: 0
        },
        orderItemSN: "",
        productID: "",
        quantity: 0,
        itemPrice: 0,
        standPrice: 0
      },
    }
  },
  created() {
    this.search();
  },
  computed: {
    
  },
  methods:{
    total() {
      var total = 0
      for(var data of this.tableData){
        if(data.number !== 0){
          total += data.price * data.number
        }
      }
      return total;
    },

    search(){
      axios.get('http://localhost:8080/search', axiosConfig)
      .then(res =>{
         this.tableData = res.data;
        })
        .catch(error => {
        console.error('Error:', error);
        });
    },
    
    save(){
      
      for(var data of this.tableData){
        axios.get('http://localhost:8080/search/'+ data.productId, axiosConfig)
        .then(res =>{
            if (res.data.quantity <= data.number){
              this.show_ok = true;
              this.messageText="新增失敗，請重新輸入數字!";
              data.number = 0;
              return ;
            }
          })
      }      
      
      var orderId = "123123123123";
      var SN = "123123123123";

      for(data of this.tableData){
        if (data.number > 0){
          this.formOrderData.orderID.orderDetail = null;
          this.formOrderData.quantity = data.number;
          this.formOrderData.standPrice = data.price;
          this.formOrderData.orderID.price = data.price;
          this.formOrderData.orderItemSN = SN;
          this.formOrderData.productID = data.productId;
          this.formOrderData.orderID.orderID = orderId;
          this.formOrderData.itemPrice = data.number * data.price;
          axios.post('http://localhost:8080/createProduct', this.formOrderData, axiosConfig)
          .then(res =>{
            this.show_ok = true;
            this.messageText="新增成功!";
            })
          .catch(error => {
            console.error('Error:', error);
          });
        }
      }      
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