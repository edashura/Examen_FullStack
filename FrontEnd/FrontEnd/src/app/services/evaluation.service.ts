import { Injectable } from '@angular/core';
import {EvaluationComponent} from "../components/evaluation/evaluation/evaluation.component";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class EvaluationService {

  constructor(private httpClient: HttpClient) { }

  public createEval(auteur: string, commentaire: string, nbEtoiles: number): Observable<EvaluationComponent>{
    return this.httpClient.post<EvaluationComponent>('http://localhost:8080/restaurants/{id}/evaluation', {auteur: auteur, commentaire: commentaire, nbEtoiles: nbEtoiles})
  }
}
