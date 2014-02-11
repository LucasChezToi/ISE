LC=pdflatex
LFLAGS=-halt-on-error 
LSRC=rendu1.tex
PDF=rendu1.pdf

all: rapport


rapport: 
	$(LC) $(LFLAGS) $(LSRC)
	@touch $(PDF) # To refresh the PDF viewer

see: rapport
	evince $(PDF)

clean:
	rm -f *.aux *.eps *.log *.pdf *.toc *~ *.out

