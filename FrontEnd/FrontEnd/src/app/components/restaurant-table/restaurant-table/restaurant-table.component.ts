import {ChangeDetectorRef, Component, Input, OnInit} from '@angular/core';
import {Restaurant} from "../../../dto/restaurant.dto";
import {Router} from "@angular/router";
import {NgForOf, NgIf} from "@angular/common";
import {CouleurDirective} from "../../../directive/couleur.directive";
import {RestaurantService} from "../../../services/restaurant.service";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-restaurant-table',
  standalone: true,
  imports: [
    NgForOf, CouleurDirective, NgIf, FormsModule
  ],
  templateUrl: './restaurant-table.component.html',
  styleUrl: './restaurant-table.component.css'
})
export class RestaurantTableComponent implements OnInit {

  @Input()
  public restaurants: Restaurant[] = [];
  public filterText: string = '';
  constructor(
      private restaurantService: RestaurantService,
      private router: Router,
      private cdr: ChangeDetectorRef) {
  }

  ngOnInit(): void {
  }

  public navigateToDetails(id: number) {
    this.router.navigate(['restaurants/' + id])
  }
  applyFilter(): void {
    this.cdr.detectChanges();
  }
}
