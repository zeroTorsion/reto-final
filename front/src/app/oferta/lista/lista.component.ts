import { Component, OnInit } from '@angular/core';
import { ServiceService, iOfertas} from '../service.service';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {
  lista;
  oferta = {} as iOfertas;
  constructor(private servicio: ServiceService) { }

  ngOnInit() {
    this.rellenar();
  }
  crearOferta(oferta){
    this.servicio.createOferta(oferta.vcTitulo,oferta.vcDescr,oferta.vcDescu,oferta.vcFexp).subscribe(data =>{
      this.rellenar();
      this.oferta = data;
    })
  }
  rellenar(){
    this.servicio.getOfertas().subscribe(data=>{
      this.lista=data;
      
    })
  }
}
