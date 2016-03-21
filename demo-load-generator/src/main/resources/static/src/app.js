import {inject} from 'aurelia-framework';
import {HttpClient} from 'aurelia-fetch-client';
import 'fetch';

@inject(HttpClient)
export class App {
    message = 'Demo Load Generator';
    piDigits = 0;
    repeat = 0;
    delay = 1000;

    constructor(http) {
        this.http = http;
    }

    generateLoad() {
        let result = this.http.fetch("/load/" + this.piDigits * 3 + "/requestCount/" + this.repeat + "/delayMS/" + this.delay);
        alert(`Pi Digits: ${this.piDigits} Repeat: ${this.repeat} Delay: ${this.delay}`);
        return result;
    }
}
