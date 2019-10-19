import { NgbDatepickerI18n } from '@ng-bootstrap/ng-bootstrap';
import { Injectable } from '@angular/core';

const labels = {
    weekdays: ['dom', 'seg', 'ter', 'qua', 'qui', 'sab', 'dom'],
    months: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez']
}

@Injectable()
export class DateLabelUtil extends NgbDatepickerI18n {
    
    constructor() {
        super();
    }
    
    getDayAriaLabel(date: import("@ng-bootstrap/ng-bootstrap").NgbDateStruct): string {
        return date.day.toString();
    }

    getWeekdayShortName(weekday: number): string {
        return labels.weekdays[weekday - 1];
    }

    getMonthShortName(month: number): string {
        return labels.months[month - 1];
    }

    getMonthFullName(month: number): string {
        return this.getMonthShortName(month);
    }
}