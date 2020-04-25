import { Component, OnInit, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ICategory, IItem } from '../shared/interfaces';
import { DataService } from '../core/data.service'
import { from } from 'rxjs';

@Component({
  selector: 'app-entry',
  templateUrl: './entry.component.html',
  styleUrls: ['./entry.component.css']
})
export class EntryComponent implements OnInit {

  categories: ICategory[];
  items: IItem[];
  constructor(private dataService: DataService) { }
  entryAmount: number = 23;
  description: string;


  ngOnInit(): void {
    this.dataService.getCategories().subscribe((returnedCategories: ICategory[]) => this.categories = returnedCategories);
  }

  submit() {
    console.log(this.description);
  }
  getItems(id: any){
    this.dataService.getItems(id).subscribe((returnedItems: IItem[]) => this.items = returnedItems);
  }
}
