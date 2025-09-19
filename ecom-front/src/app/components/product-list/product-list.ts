import {Component, OnInit} from '@angular/core';
import {Api, Product} from '../../services/api';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-product-list',
  imports: [CommonModule],
  templateUrl: './product-list.html',
  styleUrl: './product-list.css'
})
export class ProductList implements OnInit {
  products: Product[] = [];
  loading = true;
  error: string | null = null;

  constructor(private api: Api) {}

  ngOnInit(): void {
    this.api.getProducts().subscribe({
      next: (data) => {
        this.products = data;
        this.loading = false;
      },
      error: (err) => {
        console.error('Erreur chargement products', err);
        this.error = 'Impossible de charger les produits';
        this.loading = false;
      }
    });
  }
}
