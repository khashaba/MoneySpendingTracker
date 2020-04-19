import { Component, OnInit, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ICategory } from '../shared/interfaces';
import { DataService } from '../core/data.service'
import { from } from 'rxjs';

@Component({
  selector: 'app-entry',
  templateUrl: './entry.component.html',
  styleUrls: ['./entry.component.css']
})
export class EntryComponent implements OnInit {

  categories: any[];
  constructor(private dataService: DataService) { }
  entryAmount: number = 23;
  description: string;


  ngOnInit(): void {
    this.dataService.getCategories().subscribe((returnedCategories: ICategory[]) => this.categories = returnedCategories);
    console.log(this.categories)
  }

  submit() {
    console.log(this.description);
  }
}
