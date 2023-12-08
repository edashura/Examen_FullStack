import {RouterModule, Routes} from '@angular/router';
import {RestaurantComponent} from "./components/restaurant/restaurant/restaurant.component";
import {DetailsComponent} from "./components/details/details/details.component";
import {NgModule} from "@angular/core";

export const routes: Routes = [
  {path: '', redirectTo: 'restaurants', pathMatch: "full"},
  {path: 'restaurants', component: RestaurantComponent},
  {path: 'restaurants/:id', component: DetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
