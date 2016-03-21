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
        http.configure(config => {
            config
                .useStandardConfiguration()
                .withBaseUrl('http://localhost:8081');
        });

        this.http = http;
    }

    generateLoad() {
        return this.http.fetch("/load/" + this.piDigits * 3 + "/requestCount/" + this.repeat + "/delayMS/" + this.delay);
        alert(`Pi Digits: ${this.piDigits} Repeat: ${this.repeat} Delay: ${this.delay}`);
    }
}
