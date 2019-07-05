import { OfertaModule } from './oferta.module';

describe('OfertaModule', () => {
  let ofertaModule: OfertaModule;

  beforeEach(() => {
    ofertaModule = new OfertaModule();
  });

  it('should create an instance', () => {
    expect(ofertaModule).toBeTruthy();
  });
});
