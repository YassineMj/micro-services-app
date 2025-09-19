import {Component, OnInit} from '@angular/core';
import {Api, Billing} from '../../services/api';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-billing-list',
  imports: [CommonModule],
  templateUrl: './billing-list.html',
  styleUrl: './billing-list.css'
})
export class BillingList implements OnInit {
  billings: Billing[] = [];
  loading = true;
  error: string | null = null;

  constructor(private api: Api) {}

  ngOnInit(): void {
    this.api.getBillings().subscribe({
      next: (data) => {
        this.billings = data;
        this.loading = false;
      },
      error: (err) => {
        console.error('Erreur chargement billings', err);
        this.error = 'Impossible de charger les factures';
        this.loading = false;
      }
    });
  }

  // Calcule le total d’une facture
  getTotal(billing: Billing): number {
    return billing.productItems.reduce((sum, item) => sum + item.unitPrice * item.quantity, 0);
  }
}
