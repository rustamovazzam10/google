-- liquibase formatted sql

-- changeset salikhdev:1769436853996-1
ALTER TABLE _user
    ADD COLUMN updated_at TIMESTAMP;


-- changeset salikhdev:1769436853996-2
ALTER TABLE courses
    ADD COLUMN updated_at TIMESTAMP;


-- changeset salikhdev:1769436853996-3
ALTER TABLE group_students
    ADD COLUMN updated_at TIMESTAMP;