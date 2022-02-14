/** /*:
 * @target MZ
 * @author Corey Mckeel
 * @plugindesc My first plugin
 * 
 * 
*/

(
    () => {
        class Thing {
            constructor() {
                this.banana = 50;
                this.sour ="yes";
            }

            yell() {
                console.log(this.banana, this.sour);
            }
        }

        var thing = new Thing();
    }
)();