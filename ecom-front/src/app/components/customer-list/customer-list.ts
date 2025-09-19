import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Api, Customer } from '../../services/api';

@Component({
  selector: 'app-customer-list',
  imports: [CommonModule],
  templateUrl: './customer-list.html',
  styleUrls: ['./customer-list.css']
})
export class CustomerList {
  customers: Customer[] = [];
  loading = true;
  error: string | null = null;

  constructor(private api: Api) {}

  ngOnInit(): void {
    this.api.getCustomers().subscribe({
      next: (data) => {
        this.customers = data;
        this.loading = false;
      },
      error: (err) => {
        console.error('Erreur chargement customers', err);
        this.error = 'Impossible de charger les clients';
        this.loading = false;
      }
    });
  }
}
