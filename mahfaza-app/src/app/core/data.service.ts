import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

import { ICategory } from '../../app/shared/interfaces';

@Injectable()
export class DataService {

    baseUrl: string = 'http://localhost:8080';


    constructor(private http: HttpClient) { }

    getCategories(): Observable<ICategory[]> {
        return this.http.get<ICategory[]>(this.baseUrl + "/categories")
            .pipe(
                catchError(this.handleError)
            );
    }

    private handleError(error: any) {
        console.error('server error:', error);
        if (error.error instanceof Error) {
            const errMessage = error.error.message;
            return Observable.throw(errMessage);
            // Use the following instead if using lite-server
            // return Observable.throw(err.text() || 'backend server error');
        }
        return Observable.throw(error || 'Node.js server error');
    }

}