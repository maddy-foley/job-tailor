import { checkFiles} from './config.js';
import { makePDF } from './document.js';



await checkFiles();
makePDF();

