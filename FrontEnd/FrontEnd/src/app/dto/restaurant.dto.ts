import {EvaluationComponent} from "../components/evaluation/evaluation/evaluation.component";


export interface Restaurant {
  id: number;
  nom: string;
  adresse: string;
  moyenneEvaluations: number;
  evaluations: EvaluationComponent[];
}
