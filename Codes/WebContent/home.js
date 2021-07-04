 window.onload=function(){
 stu=document.getElementsByClassName("content")[0];
 mp=stu.getElementsByClassName("mainpage")[0];
 smenu=stu.getElementsByClassName("sidebar")[0];
 mp.src="welcome.html";
};

function stuload()
{   
    console.log("stu1");
    mp.src="stuindex.html";
    //mp.style.height = (mp.contentWindow.document.body.scrollHeight+5) + 'px';
    
    //mp.load("studentview.jsp");
    //mp.innerHTML="students";

}
function courseload()
{   
	mp.src="courseindex.html";

}
function gradesload()
{   
	mp.src="gradeindex.html";
	    

}
function updateload()
{   
	mp.src="updateindex.html";

}
function reportload()
{   
	mp.src="reportindex.html";

};