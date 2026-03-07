import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[Highlight]',
  standalone: true
})
export class Highlight {
  @Input() Highlight = 'yellow';


  constructor(private el: ElementRef) { }

  @HostListener('mouseenter')
  onMouseEnter() {
    this.el.nativeElement.style.backgroundColor = this.Highlight;
  }

  @HostListener('mouseleave')
  onMouseLeave() {
    this.el.nativeElement.style.backgroundColor = '';
  }

}
