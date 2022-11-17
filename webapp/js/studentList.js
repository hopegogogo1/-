window.onload = function(){

	var msgListUl = document.getElementById( 'msgList-ul' )
	var liList = msgListUl.childNodes
	liList.forEach( function ( item, index ){
		item.onclick = function(){
			clickItem(this)
		}
	})

	var modifyBtn = document.getElementById( 'modify-btn' )
	modifyBtn.onclick = function(){
		showModal( 'modify' )
	}

	var addBtn = document.getElementById( 'add-btn' )
	addBtn.onclick = function(){
		showModal( 'add' )
	}

	var delBtn = document.getElementById( 'del-btn' )
	delBtn.onclick = function(){
		deleteMsg()
	}

	var closeModalBtn = document.getElementById( 'close-modal-btn' )
	closeModalBtn.onclick = function(){
		closeModal()
	}

	var submitBtn = document.getElementById( 'submit-button' )
	submitBtn.onclick = function(){
		submitForm()
	}

	/*var studentListShow=document.getElementById("studentList")
	studentListShow.onclick=function (){
		var frame=document.getElementById("myFrame");
		frame.src="echarts.js/index.html";
	}*/
}

function submitForm(){
	document.msgForm.submit()
	/*if( document.msgForm.action.value == 'add' ){
		addMsg()
	}
	if( document.msgForm.action.value == 'modify' ){
		modifyMsg()
	}*/
}

function deleteMsg(){
	var li = document.getElementsByClassName( 'active-li' )
	if( li.length > 0 ){
		var name = li[0].getElementsByClassName( 'name-span' )[0].innerHTML
		var id = li[0].getElementsByClassName( 'id-input' )[0].value
		console.log(id)
		if( confirm( '确定要删除【' + name + '】的记录吗？') ){
			window.open( "../servlet/student.do?action=del&id=" + id )
		}
	}
	else{
		alert( '请点击选择要删除的记录！' )
	}
}

/*
function addMsg(){
	document.msgForm.submit()
}

function modifyMsg(){
	document.msgForm.submit()
}
*/
function clickItem( li ){
	if( li.className.indexOf( 'active-li' ) > -1 ){
		li.className = li.className.replace( ' active-li', '' )
	}
	else{
		var activeItems = document.getElementsByClassName( 'active-li' )
		if( activeItems.length > 0 ){
			for( var i=0; i<activeItems.length; i++){
				activeItems[i].className = activeItems[i].className.replace( ' active-li', '' )
			}
		}
		li.className = li.className + ' active-li'
	}
}

function closeModal(){
	var modalDiv = document.getElementsByClassName( 'modal-div' )[0]
	modalDiv.className = 'modal-div ' + 'fade-out'
	setTimeout( function(){
		modalDiv.style.display = 'none'
		modalDiv.className = 'modal-div'
		document.msgForm.reset()
	}, 1000)
}

function showModal( act ){
	if( act == 'modify' ){
		var li = document.getElementsByClassName( 'active-li' )
		if( li.length < 1 ){
			alert( '请点击选择要修改的信息！' )
			return
		}
		setFormByLi( li[0] )
		document.msgForm.id.value = li[0].getElementsByClassName( "id-input" )[0].value
	}
	var modalDiv = document.getElementsByClassName( 'modal-div' )[0]
	document.msgForm.action.value = act
	modalDiv.style.display = 'flex'

	setTimeout( function(){
		modalDiv.className = 'modal-div ' + 'fade-in'
	}, 0)
	var title = modalDiv.getElementsByTagName( 'h2' )[0]
	if( 'add' == act ){
		title.innerHTML = '<span style="color: #f66;">新增</span>'
	}
	else{
		title.innerHTML = '<span style="color: #f66;">修改</span>'
	}
}

function setLiByForm( li ){
	var msgForm = document.msgForm

	var numSpan = li.getElementsByClassName( 'num-span' )[0]
	numSpan.innerHTML = msgForm['number'].value

	var nameSpan = li.getElementsByClassName( 'name-span' )[0]
	nameSpan.innerHTML = msgForm['name'].value

	var img = li.getElementsByTagName( 'img' )[0]
	var sexSpan = li.getElementsByClassName( 'sex-span' )[0]
	sexSpan.innerHTML = msgForm['sex'].value

	if( msgForm['sex'].value == 'male' ){
		li.className = 'male'
		if( Math.random() > 0.5 ){
			img.src = '../img/9901.png'
		}
		else{
			img.src = '../img/9903.png'
		}
	}
	else{
		li.className = 'female'
		if( Math.random() > 0.5 ){
			img.src = '../img/9902.png'
		}
		else{
			img.src = '../img/9904.png'
		}
	}

	var departSpan = li.getElementsByClassName( 'depart-span' )[0]
	departSpan.innerHTML = msgForm['department'].value

	var likeSpan = li.getElementsByClassName( 'like-span' )[0]
	likeSpan.innerHTML = ''
	msgForm['like'].forEach( function( item, index ){
		if( item.checked ){
			likeSpan.innerHTML += item.nextElementSibling.outerHTML
		}
	})
	return li
}

function setFormByLi( li ){
	var msgForm = document.msgForm

	var numSpan = li.getElementsByClassName( 'num-span' )[0]
	msgForm['number'].value = numSpan.innerHTML

	var nameSpan = li.getElementsByClassName( 'name-span' )[0]
	msgForm['name'].value = nameSpan.innerHTML

	var sexSpan = li.getElementsByClassName( 'sex-span' )[0]
	msgForm['sex'].value = sexSpan.innerHTML

	var departSpan = li.getElementsByClassName( 'depart-span' )[0]
	msgForm['department'].value = departSpan.innerHTML

	var likeSpan = li.getElementsByClassName( 'like-span' )[0]
	msgForm['like'].forEach( function( item, index ){
		if( likeSpan.innerHTML.indexOf( item.nextElementSibling.innerHTML ) > -1 ){
			item.checked = 'checked'
		}
	})
}
