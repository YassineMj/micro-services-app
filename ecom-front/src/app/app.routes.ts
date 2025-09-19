import { Routes } from '@angular/router';
import {CustomerList} from './components/customer-list/customer-list';
import {ProductList} from './components/product-list/product-list';
import {BillingList} from './components/billing-list/billing-list';

export const routes: Routes = [
  { path: '', redirectTo: 'customers', pathMatch: 'full' },
  { path: 'customers', component: CustomerList },
  { path: 'products', component: ProductList },
  { path: 'billings', component: BillingList }
];
