(function ($) {
  "use strict";
  let imgs = $(".content-thumbnail--placeholder, .placeholder-img");
  for (let a = 0; a < imgs.length; a++) {
    loadImage(imgs[a]);
  }

  function loadImage(elem) {
    let url = $(elem).attr("ref-src");
    let alt = $(elem).attr("ref-alt");
    if (!url) return;
    let newImg = new Image();
    newImg.onload = function () {
      $(elem).attr("src", url);
      $(elem).attr("alt", alt);
      $(elem).removeClass(".content-thumbnail--placeholder");
    };
    newImg.src = url;
  }

})(jQuery);