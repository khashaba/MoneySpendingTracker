import { Component, OnInit } from '@angular/core';
import {DataService} from '../core/data.service';
import {ICategory, IItem} from '../shared/interfaces';

@Component({
  selector: 'app-admin-view',
  templateUrl: './admin-view.component.html',
  styleUrls: ['./admin-view.component.css']
})
export class AdminViewComponent implements OnInit {
  categories: any[];
  items:any[];
  selectedCategory:ICategory;
  selectedItem:IItem;

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.dataService.getCategories().subscribe((returnedCategories: ICategory[]) => this.categories = returnedCategories);

  }
  getCategoryItems(category){
    this.dataService.getCategoryItems(category.id).subscribe((returnedItems: IItem[]) => this.items = returnedItems);
    console.log(this.items)

  }
  getEntriesInItem(item){
    //TODO
  }

}
