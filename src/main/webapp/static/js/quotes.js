var quote=new Array();
  quote[0]='"It’s not a bug – it’s an undocumented feature."';    /* add as many quotes as you like!*/
  quote[1]='"They dont make bugs like Bunny anymore."';
  quote[2]='"The best thing about a boolean is even if you are wrong, you are only off by a bit. "';
  quote[3]='"Before software can be reusable it first has to be usable."';
  quote[4]='"One man’s crappy software is another man’s full time job."';
  quote[5]='"Programming is like sex. One mistake and you have to support it for the rest of your life. "';
  quote[6]='"In order to understand recursion, one must first understand recursion. "';
  quote[7]='"Don’t worry if it doesn’t work right. If everything did, you’d be out of a job."';
  quote[8]='"In theory, there is no difference between theory and practice. But, in practice, there is."';


var speed=5000;    /*this is the time in milliseconds adjust to suit*/
var q=0;

function showQuote() {

     document.getElementById("quotes").innerHTML=quote[q];
     q++;
if(q==quote.length) {
     q=0;
  }
}
setInterval('showQuote()',speed);