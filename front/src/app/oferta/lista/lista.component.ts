import { Component, OnInit } from '@angular/core';
import { ServiceService} from '../service.service';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {
  lista;
  constructor(private servicio: ServiceService) { }

  ngOnInit() {
    this.servicio.getOfertas().subscribe(data=>{
      this.lista=data;
      
    })
  }

}
