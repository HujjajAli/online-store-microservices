import { Injectable } from '@angular/core';
import { HttpService } from './http.service';

@Injectable({
  providedIn: 'root'
})
export class UtilApiService {

  constructor(private httpService:HttpService) { }

  public getAllProvinces(){
    return this.httpService.get('http://localhost:8083/util/lov/province')
  }

  public getAllCitiesByProvince(provinceId:any){
    let url = 'http://localhost:8083/util/lov/city/provinceid/'+provinceId;
    console.log('Cities by Province URL');
    return this.httpService.get(url);
  }
}
