function area(a){
	let type = typeof(a);
	if(type === 'number'){
		let result = Math.pow(a,2)*Math.PI;
		console.log(result.toFixed(2));
	}else{
		console.log(`We can not calculate the circle area, because we receive a ${}.`);
	}
	
}