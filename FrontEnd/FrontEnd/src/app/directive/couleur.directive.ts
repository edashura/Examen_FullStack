import {Directive, ElementRef, Input, Renderer2} from '@angular/core';

@Directive({
  selector: '[appCouleur]',
  standalone: true
})
export class CouleurDirective {

  @Input('appCouleur')
  set appCouleur(index: string) {

    if (parseInt(index) > 1) {
      this._renderer.setStyle(this._el.nativeElement, 'background-color', 'yellow')
    } else {
      if (parseInt(index) < 1 && parseInt(index) > 0) {
        this._renderer.setStyle(this._el.nativeElement, 'background-color', 'red')
      }
    }

  }

  constructor(private _el: ElementRef, private _renderer: Renderer2) {

  }

}
