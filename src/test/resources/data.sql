--
-- PostgreSQL database dump
--

-- Dumped from database version 12.7
-- Dumped by pg_dump version 12.9 (Ubuntu 12.9-0ubuntu0.20.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: testGetAllBookings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.booking (
    id bigint NOT NULL,
    creator character varying(255),
    date_created timestamp without time zone,
    date_updated timestamp without time zone,
    updater character varying(255),
    accommodation_contact character varying(255),
    accommodation_needs character varying(255),
    address1 character varying(255),
    address2 character varying(255),
    country character varying(255),
    postcode character varying(255),
    town character varying(255),
    children18months_to5years integer,
    children5years_to11years integer,
    children_under18months integer,
    college character varying(255),
    date timestamp without time zone,
    discount_code character varying(255),
    email character varying(255),
    firstname character varying(255),
    hear_about character varying(255),
    is_actioned boolean,
    lastname character varying(255),
    other_membership character varying(255),
    status character varying(255),
    telephone character varying(255),
    after_party boolean,
    friday integer,
    ticket_pricing character varying(255) NOT NULL,
    saturday integer,
    sunday integer,
    thursday integer,
    ticket_type character varying(255) NOT NULL,
    ticket_web_price character varying(255),
    trade_union character varying(255)
);


ALTER TABLE public.booking OWNER TO festival;

--
-- Name: booking_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.booking_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.booking_id_seq OWNER TO festival;

--
-- Name: booking_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.booking_id_seq OWNED BY public.booking.id;


--
-- Name: testGetAllBookings id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.booking ALTER COLUMN id SET DEFAULT nextval('public.booking_id_seq'::regclass);

--
-- Name: booking_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.booking_id_seq', 1, false);


--
-- Name: testGetAllBookings booking_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.booking
    ADD CONSTRAINT booking_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

