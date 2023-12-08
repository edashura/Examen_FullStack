import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {EvaluationComponent} from "../../evaluation/evaluation/evaluation.component";
import {FormsModule, NgForm} from "@angular/forms";
import {NgIf} from "@angular/common";
import {RestaurantService} from "../../../services/restaurant.service";
import {Restaurant} from "../../../dto/restaurant.dto";

@Component({
  selector: 'app-restaurant-form',
  standalone: true,
  imports: [
    FormsModule,
    NgIf
  ],
  templateUrl: './restaurant-form.component.html',
  styleUrl: './restaurant-form.component.css'
})
export class RestaurantFormComponent implements OnInit {

  public nomInput: string = "";
  public adressInput: string = "";
  public moyenneEvaluations: number = 0;
  public message: string = ""
    public restaurants: Restaurant[] = [];
  @Output()
  public restaurantCreated: EventEmitter<RestaurantFormContent> = new EventEmitter();

  constructor(private restaurantService: RestaurantService) {
  }

  ngOnInit(): void {
  }

  public save(form: NgForm): void {
      if (form.valid) {
          console.log("resto valid")

          this.restaurantService.createRestaurant(this.nomInput, this.adressInput, this.moyenneEvaluations).subscribe();
          this.message = "Restaurant ajouté"
      }
      else {
        this.message = "Ca marche paaaas"
      }

  }
}

export interface RestaurantFormContent {
  nom: string;
  adress: string;
  moyenneEvaluations: number;
}
