import {Component, Input, OnInit} from '@angular/core';
import {Restaurant} from "../../../dto/restaurant.dto";
import {RestaurantService} from "../../../services/restaurant.service";
import {RestaurantTableComponent} from "../../restaurant-table/restaurant-table/restaurant-table.component";
import {CouleurDirective} from "../../../directive/couleur.directive";
import {NgForOf, NgIf} from "@angular/common";
import { Location } from '@angular/common';
import { ChangeDetectorRef } from '@angular/core';


@Component({
  selector: 'app-details',
  standalone: true,
  imports: [
    RestaurantTableComponent,
    CouleurDirective,
    NgForOf,
    NgIf
  ],
  templateUrl: './details.component.html',
  styleUrl: './details.component.css'
})
export class DetailsComponent implements OnInit {

  public message: string = ""
  constructor(private restaurantService: RestaurantService,
  private location: Location) {
  }

  @Input()
  public restaurants: Restaurant[] = [];
  public ngOnInit(): void {
    const currentUrl = this.location.path();
      this.restaurantService.getDetailRestaurant(currentUrl).subscribe({
        next: restaurants => {
          this.restaurants = restaurants;
        }
      }
      )
    }
}


