// Implement the methods in PizzaService for Task 3
// Add appropriate parameter and return type 
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom } from "rxjs";

const URL = 'http://localhost:8080/api/order'
const URLGet = 'http://localhost:8080/api/order/:email'


@Injectable()
export class PizzaService {

  

  constructor(private http:HttpClient) { }

  // POST /api/order
  // Add any required parameters or return type
  createOrder(name: string, email: string, size: string, base: string, sauce: string, toppings: [], comments: string) {
      const data = new FormData()
      data.set('name',name)
      data.set('email',email)
      data.set('size', size)
      data.set('base',base)
      data.set('sauce',sauce)
      //data.set('toppings', )
      data.set('comments',comments)

      const headers = new HttpHeaders()
        .set('Content-Type', 'application/x-www-form-urlencoded')

      //this.http.post<any>()

      return firstValueFrom(
        this.http.post<any>(URL, data.toString(), { headers })
      )

  } 

  // GET /api/order/<email>/all
  // Add any required parameters or return type
  getOrders(/* add any required parameters */) { 
  }

}
