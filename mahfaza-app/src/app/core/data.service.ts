import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';
import { map, catchError, retry } from 'rxjs/operators';

import { ICategory, IItem, IRecord } from '../../app/shared/interfaces';

@Injectable()
export class DataService {

    baseUrl: string = 'http://localhost:8080';
    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })
    };
    constructor(private http: HttpClient) { }

    getCategories(): Observable<ICategory[]> {
        return this.http.get<ICategory[]>(this.baseUrl + "/categories")
            .pipe(
                catchError(this.handleError)
            );
    }

    getItems(id: number): Observable<IItem[]> {
        return this.http.get<IItem[]>(this.baseUrl + `/categories/${id}/items`)
            .pipe(
                map((response: IItem[]) => response as IItem[]),
                catchError(this.handleError)
            );
    }
    AddRecords(record: IRecord): Observable<IRecord> {
        return this.http
            .post<IRecord>(this.baseUrl + "/records", record, this.httpOptions)
            .pipe(
                retry(1),
                catchError(this.handleError)
            );
    }
    private handleError(error: any) {
        console.error('server error:', error);
        if (error.error instanceof Error) {
            const errMessage = error.error.message;
            return Observable.throw(errMessage);
        }
        return Observable.throw(error || 'server error');
    }

}