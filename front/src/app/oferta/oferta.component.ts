import { Component, OnInit } from '@angular/core';
import { ServiceService} from './service.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-oferta',
  templateUrl: './oferta.component.html',
  styleUrls: ['./oferta.component.css']
})
export class OfertaComponent implements OnInit {

  lista;
  constructor(private router: Router,private servicio: ServiceService) { }

  ngOnInit() {
    this.servicio.getOfertas().subscribe(data=>{
      this.lista=data;
      
    })
  }
  addOferta(){
    this.router.navigate(['/ofertasadd']);
  }
  
}
