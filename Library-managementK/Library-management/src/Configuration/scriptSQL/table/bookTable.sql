CREATE TABLE IF NOT EXISTS "book" (
    id varchar(50) primary key,
    book_name varchar(200) not null,
    page_numbers int,
    release_date timestamp default now(),
    author_id int references "author"(id),
    topic Topic,
    status Status
);