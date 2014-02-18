TEX=$(wildcard *.tex)
PDF=$(TEX:%.tex=%.pdf)

all:$(TEX)
	pdflatex $(TEX)

clean:
	rm -f ./*.out ./*.aux ./*.nav ./*.log ./*.snm ./*.toc ./*~ ./*.eps
cleanall: clean
	rm -f $(PDF)