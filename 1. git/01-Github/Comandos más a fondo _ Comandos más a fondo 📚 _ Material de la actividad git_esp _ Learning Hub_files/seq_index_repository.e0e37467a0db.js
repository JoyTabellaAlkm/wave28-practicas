"use strict";

function renderCourseData(data) {
    $('.course_name').append(data['display_name']);
    $('.course_description').append(data['short_description']);
}

function renderSections(data) {
    const sections = data['children'];
    const final = sections.reduce((acc, section) => {
        const subsections = section['children'];
        const result = subsections.reduce((acc, subsection) => {
            let className = null;

            // Caso 1: subsección deshabilitada x secuencialidad
            if(subsection['enable'] === false) {
                className = 'disabled';
            } // Caso 2: subsección completa (hago override del disabled)
            if(subsection['complete']) {
                className = 'subsection--completed';
            }  // Caso 3: subsección activa actualmente (hago override de disabled y de completed)
            if(subsection['id'] === $$sequential_id) {
                if(subsection['complete']) {
                    className = 'active subsection--completed';
                } else {
                    className = 'active';
                }
            }
            const seqLiElementClass = className ? `class="${className}"` : "";
            const displayName = subsection['display_name'].split('||')[0];

            return acc + `<li ${seqLiElementClass}> <a href='${subsection['lms_web_url']}'>${displayName}</a></li>`;
        }, '');
        const subsections_str = `<ul>${result}</ul>`;
        return acc + `<h2>${section['display_name']}</h2>` + subsections_str;
    }, '');
    $('.index_sections').append(final);
}

function renderLinealProgress(data) {
    const percent = data['completion']['percent'] * 100;
    $('.course-progress-percent').prepend(`${Math.trunc(percent)}%`)
    $('.andes-progress-indicator-linear').append(`<div class='fill' style='width: ${percent}%'></div>`);
}

function loadSections(courseId) {
    $.ajax({
        method: "GET",
        url: `/meli/api/course/${courseId}/`
    }).done(function(data) {
        // imprimimos la respuesta
        renderSections(data);
        renderCourseData(data);
        renderLinealProgress(data);
        showData();
        scrollToActiveListElement();
    }).fail(function(err) {
        console.error(err);
    })
}
    
function showData() {
    $(".skeleton").hide();
    $(".progress_container").show();
}

function scrollToActiveListElement() {
    document.querySelector('li.active').scrollIntoView({ behavior: "smooth", block: "start", inline: "nearest" });
}

loadSections($$course_id);