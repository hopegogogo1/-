window.onload = function() {


    var genderAnalysis = document.getElementById( 'genderAnalysis' )
    genderAnalysis.onclick=function (){
        document.getElementById("main-div").innerHTML="<iframe src='analysis/gender'></iframe>"
    }

    var hobbyAnalysis=document.getElementById("hobbyAnalysis");
    hobbyAnalysis.onclick=function (){
        document.getElementById("main-div").innerHTML="<iframe src='analysis/likes'></iframe>"
    }

    var studentList=document.getElementById("studentList")
    studentList.onclick=function (){
        document.getElementById("main-div").innerHTML="<iframe src='servlet/student.do?action=list'></iframe>"
    }

}


