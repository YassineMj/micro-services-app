import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

  export interface Customer {
  id: string;
  username: string;
  password: string;
  name: string;
}

  export interface Product {
    id: string;
    name: string;
    price: number;
    quantity: number;
  }

export interface ProductItem {
  id: string;
  productId: string;
  quantity: number;
  unitPrice: number;
  product: Product;
}

export interface Billing {
  id: string;
  billingDate: string;
  customer: Customer;
  productItems: ProductItem[];
}

  @Injectable({
    providedIn: 'root'
  })
  export class Api {
    private BASE_URL = 'http://localhost:8888';

    constructor(private http: HttpClient) {}

    // Customers
    getCustomers(): Observable<Customer[]> {
      return this.http.get<Customer[]>(`${this.BASE_URL}/customer-service/api/customers`);
    }

    // Products
    getProducts(): Observable<Product[]> {
      return this.http.get<Product[]>(`${this.BASE_URL}/inventory-service/api/products`);
    }

    getBillings(): Observable<Billing[]> {
      return this.http.get<Billing[]>(`${this.BASE_URL}/billing-service/api/billings`);
    }
  }
