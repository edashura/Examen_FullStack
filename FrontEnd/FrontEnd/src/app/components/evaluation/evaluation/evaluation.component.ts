import {Component, OnInit} from '@angular/core';
import {EvaluationService} from "../../../services/evaluation.service";
import {RestaurantTableComponent} from "../../restaurant-table/restaurant-table/restaurant-table.component";

@Component({
  selector: 'app-evaluation',
  standalone: true,
    imports: [
        RestaurantTableComponent
    ],
  templateUrl: './evaluation.component.html',
  styleUrl: './evaluation.component.css'
})

export class EvaluationComponent implements OnInit {
  public evaluations : EvaluationComponent[] = [];
  public auteur: string = ""
  public commentaire: string = ""
  public nbEtoiles: number = 0

  constructor(private evaluationService: EvaluationService) {
  }

  ngOnInit(): void {
  }

  public createEvaluation(auteur: string, commentaire: string, nbEtoiles: number): void{
    this.evaluationService.createEval(auteur, commentaire, nbEtoiles).subscribe({
      next: value => this.evaluations.push(value)
    })
  }
}

