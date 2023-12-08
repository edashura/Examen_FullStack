import {Component, OnInit} from '@angular/core';
import {RestaurantService} from "../../../services/restaurant.service";
import {Restaurant} from "../../../dto/restaurant.dto";
import {RestaurantTableComponent} from "../../restaurant-table/restaurant-table/restaurant-table.component";
import {RestaurantFormComponent} from "../../restaurant-form/restaurant-form/restaurant-form.component";

@Component({
  selector: 'app-restaurant',
  standalone: true,
    imports: [
        RestaurantTableComponent,
        RestaurantFormComponent
    ],
  templateUrl: './restaurant.component.html',
  styleUrl: './restaurant.component.css'
})
export class RestaurantComponent implements OnInit{

  public restaurants: Restaurant[] = [];

  constructor(private restaurantService: RestaurantService) {
  }
  public ngOnInit(): void {
    this.restaurantService.getRestaurant().subscribe({
      next: restaurants => this.restaurants = restaurants
    })
  }
}
