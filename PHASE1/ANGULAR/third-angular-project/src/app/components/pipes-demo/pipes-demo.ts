import { CurrencyPipe, DatePipe, JsonPipe, LowerCasePipe, PercentPipe, SlicePipe, TitleCasePipe, UpperCasePipe } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'pipes-demo',
  imports: [UpperCasePipe,LowerCasePipe,TitleCasePipe,DatePipe, CurrencyPipe, PercentPipe, SlicePipe, JsonPipe],
  templateUrl: './pipes-demo.html',
  styleUrl: './pipes-demo.css',
})
export class PipesDemoComponent{

  name = "angular learning";
  today = new Date();
  price = 12345.678;
  percentValue = 0.75;
  message = "welcome to angular pipes demo";

  user1={
    name:"Susan",
    age:40
  }

}
