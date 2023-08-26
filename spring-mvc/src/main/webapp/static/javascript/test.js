window.addEventListener("keydown", function(event) {
    if (event.keyCode === 123) { // kiểm tra nếu phím F12 được nhấn
      event.preventDefault(); // ngăn chặn hành động mặc định của trình duyệt khi nhấn phím F12
      window.resizeTo(screen.availWidth, screen.availHeight); // co dãn kích thước của trang web để phù hợp với màn hình hiện tại
    }
  });


  //// Event tab menu
  const openMenu = document.querySelector('#icon_menu')
  const tagMenu = document.querySelector('.tab_menu')
  const btnClose = document.querySelector('.close')

  function showMenu(){
    if (tagMenu.classList.contains('open')) {
      tagMenu.classList.remove('open')
    } else {
      tagMenu.classList.add('open')
    }
  }
  function closeMenu(){
    tagMenu.classList.remove('open')
  }
  openMenu.addEventListener('click',showMenu)
  btnClose.addEventListener('click',closeMenu) 

  // bắt sự kiện thẻ lọc danh sách sản phẩm
  var listItems = document.getElementsByClassName('tab_list_menu');
  for (var i = 0; i < listItems.length; i++) {
    listItems[i].addEventListener('click', function() {
      var sublist = this.getElementsByClassName('list_clothes')[0];
      if (sublist.style.display === 'block') {
        sublist.style.display = 'none';
        this.classList.remove('openlist');
      } else {
        sublist.style.display = 'block';
        this.classList.add('openlist');
        var otherSublists = document.getElementsByClassName('list_clothes');
        for (var j = 0; j < otherSublists.length; j++) {
          if (otherSublists[j] !== sublist) {
            otherSublists[j].style.display = 'none';
            otherSublists[j].parentNode.classList.remove('openlist');
          }
        }
      }
    });
    // Ngăn chặn sự kiện lan ra đến thẻ cha
    listItems[i].getElementsByClassName('list_clothes')[0].addEventListener('click', function(event) {
      event.stopPropagation();
    });
  }
  

  //// Event price tab menu 
  var slider = document.getElementById('range');
  var output = document.getElementById('value_price')

  output.innerHTML = slider.value
  slider.oninput = function(){
    output.innerHTML = "0 - " + this.value + ".000 đ"
  }


  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/

  const productContainer = document.querySelector('.product-list-container');
  const productList = document.querySelector('#list_product');
  const product = document.querySelectorAll('.product');
  const prevButton = document.querySelector('.prev-button');
  const nextButton = document.querySelector('.next-button');


  let translateValue = 0;
  const itemWidth = 290; // Width of each product item
  const visibleItems = 5; // Number of visible items at a time
  const totalItems = productList.children.length;

  prevButton.addEventListener('click', () => {
    translateValue -= itemWidth ;
    if(translateValue <= 0 ) translateValue = 0 ;
    console.log(translateValue)
    product.forEach(item => {
      item.style.transform = `translateX(${-translateValue}px)`;
    });
  });

  nextButton.addEventListener('click', () => {
  const containerWidth = productList.offsetWidth;               //  = 1200
  const totalWidth = itemWidth * totalItems;                    // chiều rộng tổng 10 sp = 2300
  const maxTranslateValue = totalWidth - containerWidth;    // chiều rộng dư thừa còn lại

  if (translateValue >= maxTranslateValue) {
    translateValue = 0;
  } else {
    translateValue += itemWidth ;
  }
  
  product.forEach(item => {
    item.style.transform = `translateX(${-translateValue}px)`;
  });
  
  });


  


  
