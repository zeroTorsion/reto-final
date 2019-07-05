import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  of = {} as iOfertas;
  
  createOferta(vcTitulo: any, vcDescr: any, vcDescu: any, vcFexp: any) {
    this.of.id = null;
    
    this.of.vcTitulo = vcTitulo;
    this.of.vcDescr = vcDescr;
    this.of.vcDescu = vcDescu;
    this.of.vcFexp = vcFexp;
    return this.http.post<iOfertas>('http://localhost:9966/petclinic/api/ofertas',this.of);
  }


  constructor(private http: HttpClient) { }
  getOfertas(){
 return this.http.get<Array<iOfertas>>('http://localhost:9966/petclinic/api/ofertas');
  }
}
export interface iOfertas{
  id:number;
  vcTitulo:string;
  vcDescr:string;
  vcDescu:number;
  vcFexp:Date;
}
