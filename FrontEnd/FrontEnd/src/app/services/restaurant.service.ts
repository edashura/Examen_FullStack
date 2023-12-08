import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Restaurant} from "../dto/restaurant.dto";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  constructor(private httpClient: HttpClient) {

  }


  public getRestaurant(): Observable<Restaurant[]> {
    return this.httpClient.get<Restaurant[]>('http://localhost:8080/restaurants');
  }

  public getDetailRestaurant(selectedRestaurant: string): Observable<Restaurant[]> {
    return this.httpClient.get<Restaurant[]>(`http://localhost:8080${selectedRestaurant}`);
  }
  public createRestaurant(nom: string, adresse: string, moyenne: number): Observable<Restaurant> {
    return this.httpClient.post<Restaurant>('http://localhost:8080/restaurants', {nom: nom, adresse: adresse, moyenne: moyenne})
  }

  public getCoverUrl(restaurantId: number): Observable<string> {
    return this.httpClient.get<string>(`http://localhost:8080/restaurants/${restaurantId}/cover`,{responseType: 'text' as 'json'});
  }

  public getCoverUploadUrl(restaurantId: number): Observable<string>{
    return this.httpClient.put<string>(`http://localhost:8080/restaurants/${restaurantId}/cover`,{responseType: 'text' as 'json'});
  }

  public putCoverUpload(s3Url: string, file: File): Observable<string> {
    const formData = new FormData();
    formData.append('file', file);

    return this.httpClient.put<string>(s3Url, formData, { responseType: 'text' as 'json' });
  }
}
